package psyco.coderbot.web;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import psyco.user.center.client.dto.UserDTO;
import psyco.user.center.client.service.UserService;

import javax.annotation.Resource;
import java.util.Optional;

@Component
public class AuthenticationProviderCustom implements AuthenticationProvider {
    @Resource
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        String username = token.getName();
        Optional<UserDTO> userDetails = Optional.ofNullable(username).map(e -> userService.findByPhoneOrEmail(username, username));
        //
        if (!userDetails.isPresent())
            throw new UsernameNotFoundException("用户名/密码无效");
//        else if (!userDetails.isEnabled()) {
//            throw new DisabledException("用户已被禁用");
//        } else if (!userDetails.isAccountNonExpired()) {
//            throw new AccountExpiredException("账号已过期");
//        } else if (!userDetails.isAccountNonLocked()) {
//            throw new LockedException("账号已被锁定");
//        } else if (!userDetails.isCredentialsNonExpired()) {
//            throw new LockedException("凭证已过期");
//        }
        //数据库用户的密码
        String password = userDetails.get().getPassword();
        //与authentication里面的credentials相比较
        if (!password.equals(token.getCredentials())) {
            throw new BadCredentialsException("Invalid username/password");
        }
        //授权
//        return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        return new UsernamePasswordAuthenticationToken(userDetails, password, null);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        //返回true后才会执行上面的authenticate方法,这步能确保authentication能正确转换类型
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }
}
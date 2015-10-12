package psyco.coderbot.web.controller;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.repository.query.Param;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import psyco.coder.ast.core.WebResponse;
import psyco.coder.gen.CoderBuilder;
import psyco.coder.util.ExceptionExecutor;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static psyco.coder.util.ExceptionExecutor.check;


/**
 * Created by peng on 15/10/8.
 */
@RestController("/gen/")
public class GenController {

    @RequestMapping(value = "builder", method = RequestMethod.POST)
    public WebResponse builder(@Param("code") String code, HttpServletRequest request) {
        return ExceptionExecutor.exec(() -> {
            check(StringUtils.isBlank(code), "Empty input");

            if (!(request instanceof DefaultMultipartHttpServletRequest))
                return CoderBuilder.builder(code,"");

            MultiValueMap<String, MultipartFile> map = ((DefaultMultipartHttpServletRequest) request).getMultiFileMap();
            check(map.isEmpty(), "");
            List<MultipartFile> fs = map.get(map.keySet().iterator().next());
            check(fs.isEmpty(), "");
            return IOUtils.toString(fs.get(fs.size() - 1).getInputStream());
        });
    }
}

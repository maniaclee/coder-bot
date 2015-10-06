/**
 * Created by lipeng on 15/10/4.
 */

var psyco = {
    languages: {
        Java: {
            builder: {
                'image-url': '../static/worthy/images/portfolio-3.jpg',
                'description': 'Builder for Java Bean'
            },
            mybatis: {
                'image-url': '../static/worthy/images/portfolio-6.jpg',
                'description': 'mybatis'
            },
            'spring-boot-web': {
                'image-url': '../static/worthy/images/portfolio-6.jpg',
                'description': 'starter template for spring boot web'
            }
        },
        Html: {
            bean: {
                'image-url': '../static/worthy/images/portfolio-3.jpg',
                'description': 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Atque sed, quidem quis praesentium, ut unde. Quae sed, incidunt laudantium nesciunt, optio corporis quod earum pariatur omnis illo saepe numquam suscipit, nemo placeat dignissimos eius mollitia et quas officia doloremque ipsum labore rem deserunt vero! Magnam totam delectus accusantium voluptas et, tempora quos atque, fugiat, obcaecati voluptatibus commodi illo voluptates dolore nemo quo soluta quis.'
            },
            mybatis: {
                'image-url': '../static/worthy/images/portfolio-6.jpg',
                'description': 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Atque sed, quidem quis praesentium, ut unde. Quae sed, incidunt laudantium nesciunt, optio corporis quod earum pariatur omnis illo saepe numquam suscipit, nemo placeat dignissimos eius mollitia et quas officia doloremque ipsum labore rem deserunt vero! Magnam totam delectus accusantium voluptas et, tempora quos atque, fugiat, obcaecati voluptatibus commodi illo voluptates dolore nemo quo soluta quis.'
            }
        },
        Python: {
            bean: {
                'image-url': '../static/worthy/images/portfolio-3.jpg',
                'description': 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Atque sed, quidem quis praesentium, ut unde. Quae sed, incidunt laudantium nesciunt, optio corporis quod earum pariatur omnis illo saepe numquam suscipit, nemo placeat dignissimos eius mollitia et quas officia doloremque ipsum labore rem deserunt vero! Magnam totam delectus accusantium voluptas et, tempora quos atque, fugiat, obcaecati voluptatibus commodi illo voluptates dolore nemo quo soluta quis.'
            },
            mybatis: {
                'image-url': '../static/worthy/images/portfolio-6.jpg',
                'description': 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Atque sed, quidem quis praesentium, ut unde. Quae sed, incidunt laudantium nesciunt, optio corporis quod earum pariatur omnis illo saepe numquam suscipit, nemo placeat dignissimos eius mollitia et quas officia doloremque ipsum labore rem deserunt vero! Magnam totam delectus accusantium voluptas et, tempora quos atque, fugiat, obcaecati voluptatibus commodi illo voluptates dolore nemo quo soluta quis.'
            }
        },
        JavaScript: {
            bean: {
                'image-url': '../static/worthy/images/portfolio-3.jpg',
                'description': 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Atque sed, quidem quis praesentium, ut unde. Quae sed, incidunt laudantium nesciunt, optio corporis quod earum pariatur omnis illo saepe numquam suscipit, nemo placeat dignissimos eius mollitia et quas officia doloremque ipsum labore rem deserunt vero! Magnam totam delectus accusantium voluptas et, tempora quos atque, fugiat, obcaecati voluptatibus commodi illo voluptates dolore nemo quo soluta quis.'
            },
            mybatis: {
                'image-url': '../static/worthy/images/portfolio-6.jpg',
                'description': 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Atque sed, quidem quis praesentium, ut unde. Quae sed, incidunt laudantium nesciunt, optio corporis quod earum pariatur omnis illo saepe numquam suscipit, nemo placeat dignissimos eius mollitia et quas officia doloremque ipsum labore rem deserunt vero! Magnam totam delectus accusantium voluptas et, tempora quos atque, fugiat, obcaecati voluptatibus commodi illo voluptates dolore nemo quo soluta quis.'
            }
        },
        Scala: {
            bean: {
                'image-url': '../static/worthy/images/portfolio-3.jpg',
                'description': 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Atque sed, quidem quis praesentium, ut unde. Quae sed, incidunt laudantium nesciunt, optio corporis quod earum pariatur omnis illo saepe numquam suscipit, nemo placeat dignissimos eius mollitia et quas officia doloremque ipsum labore rem deserunt vero! Magnam totam delectus accusantium voluptas et, tempora quos atque, fugiat, obcaecati voluptatibus commodi illo voluptates dolore nemo quo soluta quis.'
            },
            mybatis: {
                'image-url': '../static/worthy/images/portfolio-6.jpg',
                'description': 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Atque sed, quidem quis praesentium, ut unde. Quae sed, incidunt laudantium nesciunt, optio corporis quod earum pariatur omnis illo saepe numquam suscipit, nemo placeat dignissimos eius mollitia et quas officia doloremque ipsum labore rem deserunt vero! Magnam totam delectus accusantium voluptas et, tempora quos atque, fugiat, obcaecati voluptatibus commodi illo voluptates dolore nemo quo soluta quis.'
            }
        },
    }
};

$(document).ready(function () {
    var lan = [];
    _.each(psyco.languages, function (modules, lanName) {
        _.each(modules, function (module, moduleName) {
            lan.push({
                'name': moduleName,
                'type': lanName,
                'image-url': module['image-url'],
                'description': module['description']

            });
        });
    });
    var psycoK0 = {
        koLanguages: ko.observable(lan)
    };
    ko.applyBindings(psycoK0);
    $("#fileinput-Java-bean").fileinput({
        //browseClass: "btn btn-primary btn-block",
        showPreview: false,
        showRemove:false,
        showUpload:false,
        //allowedFileExtensions: ["zip", "rar", "gz", "tgz"],
        elErrorContainer: "#errorBlock"
    });

});
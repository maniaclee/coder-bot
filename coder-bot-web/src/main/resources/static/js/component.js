/**
 * Created by lipeng on 15/10/12.
 */

var psycoComponent = {
    models: {
        'file-src-chooser': {
            viewModel: {
                createViewModel: function (params, componentInfo) {
                    return (function (params) {
                        console.log(params);
                        var _browserID = params['browserID'];
                        var _srcID = params['srcID'];
                        var browserID = ko.observable(_browserID);
                        var srcID = ko.observable(_srcID);
                        var radioGroupName = ko.observable(_browserID + "-" + _srcID);
                        this.user = ko.observable(user);
                    })();
                }
            },
            template: '<input data-bind="attr:{name:radioGroupName}"  type="radio" checked="checked"><span>Choose from file</span><label class="control-label">Select File</label><input id="fileinput-Java-bean" type="file" multiple=true class="file-loading"><div id="errorBlock" class="help-block"></div><input data-bind="attr:{name:radioGroupName}"  type="radio"><span>Paste source code</span><textarea rows="10" style="width:80%;"></textarea>'
        },
    },
    registComponent: function () {
        _.each(this.models, function (component, name) {
            console.log(name);
            console.log(component);
            ko.components.register(name, component);
        });
    }
}
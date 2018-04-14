"use strict";
//Editor Init Action
AJS.bind('init.rte', function() {
    //ToDo: Get Ajax Data to Display;
    var data = {};
    var params = initRequestParams();
    createToolbar(data);
    console.log("Unusual-Templates-Mode-Enabling");
});

function createToolbar(data) {
    //help_buttons_group
    var helpGroup = $('#rte-button-help').parent('ul');
    helpGroup.before("<ul id='t4cl-react-entry-point' class='aui-buttons aui-button-subtle rte-toolbar-group-searchreplace' />");
    //init React App
    CreativePlugins.Confluence.UT4C.render(data);
}

function initRequestParams() {
    var resultParams = {};
    try{
        resultParams.space = AJS.Data.get("space-key");
        resultParams.userkey = AJS.Data.get("remote-user");
        resultParams.isSpaceAdmin = AJS.Data.get("is-space-admin");
    } catch (e){
        //Suppress Error
    }

    return resultParams;
}
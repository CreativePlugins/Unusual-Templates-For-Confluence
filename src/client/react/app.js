import {initData} from "./utils/DataUtils";
import initStore from './store/Store';
import ReactDOM from "react-dom";
import React from "react";
import { Provider } from 'react-redux'
import IconsContainer from "./components/IconsContainer";

//Add JIRA namespace function analogue
AJS.$.namespace = function() {
    let a=arguments, o=null, i, j, d;
    for (i=0; i<a.length; i=i+1) {
        d=a[i].split(".");
        o=window;
        for (j=0; j<d.length; j=j+1) {
            o[d[j]]=o[d[j]] || {};
            o=o[d[j]];
        }
    }
    return o;
};
AJS.$.namespace("CreativePlugins.Confluence.UT4C");


CreativePlugins.Confluence.UT4C.render = function (data) {
    initData(data);
    const store = initStore();

    ReactDOM.render(
        <Provider store={store}>
            <IconsContainer />
        </Provider>,
        document.getElementById('t4cl-react-entry-point')
    );
};
import React from "react";
import {Icon, Modal} from "antd";
import {observe} from "../utils/DataUtils";
import '../../sass/nomalize.css'
import TemplatesAdministrationModule from "./administration/TemplatesAdministrationModule";
import {addShortcutInsert, insertContent} from "../utils/EditorUtils";

const Wrapper = ({children}) => children;

class IconsContainer extends React.Component {
    constructor(props) {
        super(props);
        this.unobserve = observe(this.handleChange.bind(this));

        this.handleOk = (e) => {
            insertContent("Simple Test Example");
            addShortcutInsert("ctrl+alt+o", "autobindkeys1", "My extra meta data");
            this.setState({
                visible: false,
            });
        };
    }

    handleChange(data) {
        const nextState = {data};
        if (this.state) {
            this.setState(nextState);
        } else {
            this.state = nextState;
        }
    }

    componentWillUnmount() {
        this.unobserve();
    }


    render() {
        return (
            <Wrapper>
                <li onClick={this.handleOk} className="toolbar-item aui-button aui-button-subtle cp-line-height-26" data-tooltip="Github-Popup">
                    <Icon  style={{ fontSize: 16, color: '#08c'}} type="github"/>
                </li>
                <TemplatesAdministrationModule />
            </Wrapper>
        )
    }


}

export default IconsContainer;
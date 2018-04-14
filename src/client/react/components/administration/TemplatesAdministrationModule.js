import React from "react";
import {Icon, Modal} from "antd";



class TemplatesAdministrationModule extends React.Component {
    constructor(props) {
        super(props);
        this.state = {visible: false};

        this.showModal = () => {
            this.setState({
                visible: true,
            });
        };

        this.handleOk = (e) => {
            tinyMCE.activeEditor.execCommand('mceInsertContent', false, "Simple Test Example");
            tinyMCE.activeEditor.addShortcut("ctrl+alt+o", "Short Descr", function(a){console.log(a + 1)});
            this.setState({
                visible: false,
            });
        };

        this.handleCancel = (e) => {
            console.log(e);
            this.setState({
                visible: false,
            });
        }
    }

    render(){
        return (
            <li onClick={this.showModal} className="toolbar-item aui-button aui-button-subtle cp-line-height-26" data-tooltip="Github-Popup">
                <Icon  style={{ fontSize: 16, color: '#08c'}} type="setting"/>
                <Modal title="Basic Modal" visible={this.state.visible} onOk={this.handleOk} onCancel={this.handleCancel}>
                    <p>Some contents...</p>
                    <p>Some contents...</p>
                    <p>Some contents...</p>
                </Modal>
            </li>
        )
    }

}

export default TemplatesAdministrationModule;
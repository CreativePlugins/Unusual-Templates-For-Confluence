import React from "react";
import {Icon, Modal} from "antd";
import {observe} from "../utils/DataUtils";

class IconsContainer extends React.Component {
    constructor(props) {
        super(props);
        this.unobserve = observe(this.handleChange.bind(this));
        this.state = {visible: false};

        this.showModal = () => {
            this.setState({
                visible: true,
            });
        };

        this.handleOk = (e) => {
            console.log(e);
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

    handleChange(pbData) {
        const nextState = {pbData};
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
            <li>
                <Icon onClick={this.showModal} style={{ fontSize: 16, color: '#08c', marginTop: '5px' }} type="github"/>
                <Modal
                    title="Basic Modal"
                    visible={this.state.visible}
                    onOk={this.handleOk}
                    onCancel={this.handleCancel}
                >
                    <p>Some contents...</p>
                    <p>Some contents...</p>
                    <p>Some contents...</p>
                </Modal>
            </li>
        )
    }


}

export default IconsContainer;
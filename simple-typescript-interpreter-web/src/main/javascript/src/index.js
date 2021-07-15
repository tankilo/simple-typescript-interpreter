import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import 'antd/dist/antd.css';
import { Row, Col } from 'antd';
import { Form, Input, Button } from 'antd';
import axios from 'axios';
import { Divider } from 'antd';
import { SmileTwoTone, CloseCircleTwoTone, CheckCircleTwoTone } from '@ant-design/icons';


const { TextArea } = Input;

class PlayGround extends React.Component {
  constructor(props) {
    super(props);
    this.state = {code: null, consoleOutput: null, timeCost: null, returnValue: null, successful: null};
    this.onFinish = this.onFinish.bind(this);
    this.onFinishFailed = this.onFinishFailed.bind(this);
  }

  onFinish (values)  {
    let data = {code: values.inputcode};
    axios.post("/playground/interprete", data, {headers: {'Content-Type': 'application/json'}}).then(rs => {
      this.setState({
        returnValue: rs.data.returnValue,
        consoleOutput: rs.data.consoleOutput,
        timeCost: rs.data.timeCost,
        successful: rs.data.successful
      });
    })
    console.log('Success:', values);
  }

  onFinishFailed (errorInfo)  {
    console.log('Failed:', errorInfo);
  }

  render() {
    return (
      <>
      <Row gutter={16}>
        <Col className="gutter-row" span={12}>
          <div>
            <Form
              name="basic"
              labelCol={{
                span: 4,
              }}
              wrapperCol={{
                span: 20,
              }}
              onFinish={this.onFinish}
              onFinishFailed={this.onFinishFailed}
            >
              <Form.Item
                label="inputcode"
                name="inputcode"
                rules={[
                  {
                    required: true,
                    message: 'Please input the code!',
                  },
                ]}
              >
                <TextArea rows={20} />
              </Form.Item>
              <Form.Item wrapperCol={{ offset: 8, span: 16 }}>
                <Button type="primary" htmlType="submit">
                  Submit
                </Button>
              </Form.Item>
            </Form>
          </div>
        </Col>
        <Col className="gutter-row" span={12}>
          <Row gutter={16}>
            {this.state.successful == null && <SmileTwoTone style={{ fontSize: '28px' }} twoToneColor="#1890ff"/>}
            {this.state.successful != null && this.state.successful && <CheckCircleTwoTone style={{ fontSize: '28px' }} twoToneColor="#52c41a"/>}
            {this.state.successful != null && !this.state.successful && <CloseCircleTwoTone style={{ fontSize: '28px' }} twoToneColor="#d71345"/>}
          </Row>
          <Divider orientation="left">time cost(ms)</Divider>
          <Row gutter={16}>
            {this.state.timeCost}
          </Row>
          <Divider orientation="left">expression return value:</Divider>
          <Row gutter={16}>
            {this.state.returnValue}
          </Row>
          <Divider orientation="left">Console Output</Divider>
          <Row gutter={16}>
            <div><pre>{this.state.consoleOutput}</pre></div>
          </Row>
        </Col>
      </Row>
    </>
    );
  }
}

ReactDOM.render(
 <PlayGround/>,
  document.getElementById('root'));
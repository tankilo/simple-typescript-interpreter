import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import 'antd/dist/antd.css';
import { Row, Col } from 'antd';
import { Form, Input, Button } from 'antd';

const { TextArea } = Input;

class PlayGround extends React.Component {
  constructor(props) {
    super(props);
    this.state = {code: null, result: null};
    this.onFinish = this.onFinish.bind(this); 
    this.onFinishFailed = this.onFinishFailed.bind(this); 
  }

  onFinish (values)  {
    this.setState({code: values.inputcode});
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
          <div>{this.state.code}</div>
        </Col>
      </Row>
    </>
    );
  }
}

ReactDOM.render(
 <PlayGround/>,
  document.getElementById('root'));
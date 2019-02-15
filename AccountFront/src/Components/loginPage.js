import React, {Component} from 'react'
import { Button } from 'react-bootstrap';
import '../App.css';

class Login extends Component {
	constructor(props) {
		super(props);

		this.state = {
			rmNum: '',
			booked: ''
		}
	}
	render() {
		return(<div id = "loginBox">

				<h1>Account Creation</h1>
				<br/><br/>

				First Name: <input id = 'username' type = 'text' required/><br/><br/>
				Password: <input id = 'password' type = 'text' required/><br/><br/>
				<Button bsStyle="primary" onClick = {this.props.loginButtonClick}>Submit</Button>
				</div>);
	}
}

export default Login;

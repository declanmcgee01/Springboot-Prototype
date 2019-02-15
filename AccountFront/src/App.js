import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Link} from "react-router-dom";
import './App.css';
import axios from "axios";
import { BaseURL, PathToCreateAccount, LinkRoomNumGen, LinkRegister } from './constants'
import Login from "./Components/loginPage";
import AccountCreated from "./Components/AccountCreated";
import HomePage from "./Components/HomePage";


class App extends Component {
  constructor(props) {
		super(props);

		this.state = {
      rmNum: '',
      booked: ''
		}
  }

  handleClick = () => {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

    if(username.trim()===""||password.trim()===""){
    alert("invalid input");
    }else{
      axios.post(BaseURL+PathToCreateAccount,
	  {
			username: username,
			password: password
		}).then( (response) => {
      this.setState({
        rmNum: response.data.roomNumber,
        booked: response.data.isBooked
      });
      console.log(this.state.rmNum)
      console.log(this.state.booked)

			document.getElementById("generateNum").click();

    })
  }
	}

  render() {
    return (
      <Router>
      <div className = "App">
        <center>

        <Link to = {LinkRoomNumGen} id = 'generateNum' />

        <Route exact path="/" component = {HomePage}  />
        <Route path={LinkRegister}  render={(...props) => <Login loginButtonClick={this.handleClick} />} />
        <Route path={LinkRoomNumGen}  render={(...props) => <AccountCreated rmNum={this.state.rmNum} booked={this.state.booked}/>} />

</center>
      </div>
      </Router>
    );
  }
}

export default App;

import React, { Component } from 'react';

import { BrowserRouter as Router, Link} from "react-router-dom";
import { Button } from 'react-bootstrap';
import {RegisterPageLink} from '../constants.js';

class HomePage extends Component {

    registerAccountPageLoad = () =>{
        window.location.href = RegisterPageLink;
    }

  render() {
    return (

      <div>
       <header><h1>Room Allocation App</h1></header> <br/> <br/>

            Welcome to the Room Allocation App, Register yourself to be assigned a room!!!

            <br/> <br/><br/> <br/>
            <Button bsStyle = "primary" onClick = {this.registerAccountPageLoad}>Register</Button>

      </div>
    );
  }
}

export default HomePage;

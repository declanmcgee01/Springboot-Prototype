import React, { Component } from 'react';
import Booked from './Booked.js';

import { Button } from 'react-bootstrap';

class AccountCreated extends Component {

  constructor(props){
    super(props);
    this.state = {
      rmNum: this.props.rmNum,
      booked: this.props.booked,
      windowState: 0
    }
    this.handleClick = this.handleClick.bind(this);
  }


  handleClick(){
      this.setState({
        windowState: 1,
        booked: "True"
      });
    }

  render() {

    const Main = () =>{
      return(
        <div>
          <h1>Account Successfully Created</h1>
          <br/><br/>
          <p>Room No: {this.state.rmNum}</p><br/>
          <p>Booked: {this.state.booked}</p><br/>

          <form>

          </form>
          <Button bsStyle="primary" onClick={this.handleClick}>Book Room</Button>
        </div>
      );
    }

    return (
      <div>
        {this.state.windowState===0 && <Main/>}
        {this.state.windowState===1 && <Booked rmNum = {this.state.rmNum} booked={this.state.booked}/>}
      </div>
    );
  }
}

export default AccountCreated;

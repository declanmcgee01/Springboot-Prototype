import React, { Component } from 'react';

class Booked extends Component {
  
  render() {
    return (
      <div>
        <h1>Congratulations you have booked room: </h1>
        <h1> {this.props.rmNum}</h1>
        <h1>Booked: {this.props.booked}</h1>
        <br/><br/>
      </div>
    );
  }
}

export default Booked;

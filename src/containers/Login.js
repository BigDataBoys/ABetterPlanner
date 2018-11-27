import React, {Component} from 'react';
import { render } from "react-dom";
// import axios from 'axios';

import Input from '../components/Input';
import Select from '../components/Select';
import Button from '../components/Button';


class Login extends Component {
  constructor(props) {
    super(props);
    this.state = {
      user: {
        username: '',
        password: ''
      },
    }

    this.handleUsername = this.handleUsername.bind(this);
    this.handlePassword = this.handlePassword.bind(this);
    this.handleClick = this.handleClick.bind(this);

  }

  handleUsername(e) {
    let value = e.target.value;
    this.setState(prevState => ({user: {...prevState.user, username: value}
    }), () => console.log(this.state.user))
  }

  handlePassword(e) {
    let value = e.target.value;
    this.setState(prevState => ({user: {...prevState.user, password:value}
    }), () => console.log(this.state.user))
  }

/*
  handleClick(e){
    var apiBaseUrl = "http://localhost:4000/api/";
    var self = this;
    var payload = {
      "email": this.state.username,
      "password": this.state.password
    }
    axios.post(apiBaseUrl+'login', payload).then(function (response) {
      console.log(response);
      if(response.data.code == 200){
        console.log("Login successfull");
      }
      else if(response.data.code == 204){
        console.log("Username password do not match");
        alert("username password do not match")
      }
      else{
        console.log("Username does not exists");
        alert("Username does not exist");
      }
    })
    .catch(function (error) {
      console.log(error);
    });
  }
  */

  handleRegister(e) {

  }

  render() {
    return (
      <form className = "login-form">

      <Input inputType = {'text'}
      title = {'Username: '}
      name = {'username'}
      defaultValue = ''
      placeholder = {"Enter your username"}
      handleChange = {this.handleUsername}
      />

      <Input inputType = {'text'}
      title = {'Password: '}
      name = {'password'}
      defaultValue = ''
      placeholder = {"Enter your password"}
      handleChange = {this.handlePassword}
      />

      <Button
      action = {this.handleClick} //need to redirect page with classes
      type = {'primary'}
      title = {'Login'}
      style = {buttonStyle}
      />

      <Button
      action = {this.handleRegister} //need to redirect to registration page
      type = {'secondary'}
      title = {'Register'}
      style = {buttonStyle}
      />
      </form>
    );
  }
}

const buttonStyle = {
  margin: '15px 15px 15px 15px'
}

const style = {
  margin: 15,
};
export default Login;

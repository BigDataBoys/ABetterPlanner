import React, {Component} from 'react';

//Import the Components
import Input from '../components/Input';
import Select from '../components/Select';
import Button from '../components/Button';

class Registration extends Component {
  constructor(props) {
    super(props);

//setting the state of the new user
    this.state = {
      newUser: {
        fullName: '',
        curriculumYear: '',
        major: '',
        username: '',
        password: ''

      },

      curriculumYearOptions: ['2014-2015', '2015-2016', '2016-2017', '2017-2018', '2018-2019'],
      majorOptions: ['Computer Science', 'Computer Engineer', 'Mechanicial Engineer']

    }

    this.handleFullName = this.handleFullName.bind(this);
    //this.handleFormSubmit = this.hanadleFormSubmit.bind(this);
    this.handleUsername = this.handleUsername.bind(this);
    this.handlePassword = this.handlePassword.bind(this);
    this.handleClearForm = this.handleClearForm.bind(this);
    this.handleYear = this.handleYear.bind(this);
    this.handleMajor = this.handleMajor.bind(this);
  }

  //these handle methods will be responsible for handling the change of state/value
  //for newUser

  handleFullName(e) {
    let value = e.target.value;
    this.setState( prevState => ({
      newUser : {
        ...prevState.newUser, fullName: value}
      }), () => console.log(this.state.newUser))
    }

  handleUsername(e) {
    let value = e.target.value;
    this.setState(prevState => ({newUser: {
      ...prevState.newUser, username: value}
    }), () => console.log(this.state.newUser))
  }

  handlePassword(e) {
    let value = e.target.value;
    this.setState(prevState => ({
      newUser: {
        ...prevState.newUser, password:value}
      }), () => console.log(this.state.newUser))
    }

  handleMajor(e) {
      let value = e.target.value;
      this.setState(prevState => ({
        newUser: {
          ...prevState.newUser, major: value }
        }), () => console.log(this.state.newUser))
      }
  handleYear(e) {
      let value = e.target.value;
      this.setState(prevState => ({
        newUser: {
          ...prevState.newUser, curriculumYear: value }
        }), () => console.log(this.state.newUser))
      }

   handleClearForm(e) {
      e.preventDefault();
      this.setState({
        newUser: {
          fullName: '',
          curriculumYear: '',
          major: [],
          username: '',
          password: ''
        }
      });
    }

    render() {
      return(
        <form className = "container-fluid">

        <Input inputType = {'text'}
        title = {'Name: '}
        name = {'fullName'}
        value = {this.state.newUser.fullName}
        placeholder = {'Enter your full name'}
        handleChange = {this.handleFullName}
        />

        <p> </p>
        <Select
        title = {'Curriculum Year: '}
        name = {'curriculumYear'}
        options = {this.state.curriculumYearOptions}
        value = {this.state.newUser.curriculumYear}
        placeholder = {'Select Curriculum Year '}
        handleChange = {this.handleYear}
        />

        <p> </p>
        <Select
        title = {"Major: "}
        name = {"major"}
        options = {this.state.majorOptions}
        value = {this.state.newUser.major}
        placeholder = {'Select Major '}
        handleChange = {this.handleMajor}
        />

        <p> </p>
        <Input inputType = {'text'}
        title = {'Username: '}
        name = {'username'}
        value = {this.state.newUser.username}
        placeholder = {"Enter your username"}
        handleChange = {this.handleUsername}
        />

        <Input inputType = {'text'}
        title = {'Password: '}
        name = {'password'}
        value = {this.state.newUser.password}
        placeholder = {"Enter your password"}
        handleChange = {this.handlePassword}
        />

        <Button
        action = {null} //need to redirect to page w/ classes
        type = {'primary'}
        title = {'Finish'}
        style = {buttonStyle}
        />

        <Button
        action = {this.handleClearForm}
        type = {'secondary'}
        title = {'Clear All'}
        style = {buttonStyle}
        />
        </form>

      );
    }
  }

  const buttonStyle = {
    margin: '15px 15px 15px 15px'
  }

  export default Registration;

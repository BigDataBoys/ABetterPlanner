import React, { Component } from 'react'
import courses from '../course.json'
import PropTypes from 'prop-types';
import checkboxes from '../components/checkboxes';
import Checkbox from '../components/CheckBox';

class CourseList extends Component {
  constructor(props) {
    super(props);

    this.state = {
      checkedItems: new Map(),
    }

    this.handleChange = this.handleChange.bind(this);
  }

  handleChange(e) {
    const item = e.target.name;
    const isChecked = e.target.checked;
    this.setState(prevState => ({ checkedItems: prevState.checkedItems.set(item, isChecked) }));
  }
  render() {
    return (
      <React.Fragment> {
        courses.map(item => (
          <label key={item.key}>
          <table>{item.course_number}
          <td>{item.class_number}</td>
          <td>{item.instructor}</td>
          <Checkbox name={item._id} checked={this.state.checkedItems.get(item._id)} onChange={this.handleChange} />
          </table>
          </label>
        ))
      }
      </React.Fragment>
    );
  }
}

export default CourseList

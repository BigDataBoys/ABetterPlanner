import React, { Component } from 'react'
import courses from '../course.json'

class CourseList extends Component {
  render() {
    return (
      <div>
      {courses.map((item, index) => {
        return <table>
          <tr>
          <td>{item.course_number}</td>
          <td>{item.class_number}</td>
          <td>{item.building}</td>
          <td>{item.time}</td>
          <td>{item.instructor}</td>
          </tr>
          </table>
      })}
      </div>
    )
  }
}
export default CourseList

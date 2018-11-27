import React, { Component } from 'react'

class CourseList extends Component {
  constructor() {
    super();
    this.state = {
      courses: [],
    };
  }

  componentDidMount() {
    fetch('https://mybetterplanner.com/course/api/?results=408')
    .then(results => {
      return results.json();
    }).then(data => {
      let courses = data.results.map((course) => {
        return (
          <div> {course._id, course.course_number, course.class_number, course.building, course.time, course.instructor} </div>
        )
      })
      this.setState({courses: courses});
      console.log("state", this.state.courses);
    })
  }


render() {
  return(
    <div className = "container2">
      <div className = "container1">
        {this.state.courses}
      </div>
    </div>
  )
}
}
export default CourseList;

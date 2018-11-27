
import React, { Component } from 'react';
import { render } from "react-dom";
import CourseList from './containers/CourseList'
import courses from './course.json';

class App extends Component {
  render() {
    return (
      <div className="col-md-6">
        <h1> Welcome to A Better Planner!  </h1>
        <CourseList />
      </div>
    );
  }
}
render(<App />, document.getElementById("root"));
export default App;

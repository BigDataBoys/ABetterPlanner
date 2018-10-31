import React from 'react';
import LandingPage from './landingpage';
import Projects from './project';
import AboutMe from './aboutme';
import Contact from './contact';
import Resume from './resume';

import {Switch, Route} from 'react-router-dom';
const Main = () => (
	<Switch>
		<Route exact path="/" component={LandingPage} />
		<Route path="/aboutme" component ={AboutMe} />
		<Route path="/contact" component ={Contact} />
		<Route path="/project" component ={Projects} />
		<Route path="/resume" component ={Resume} />
	</Switch>
)

export default Main;
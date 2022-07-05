import React from 'react'

const lectureList = React.lazy(() => import('./views/lecture/List'))
const lectureRegistration = React.lazy(() => import('./views/lecture/Registration'))
const applicationInquiry = React.lazy(() => import('./views/lecture/ApplicationInquiry'))

const routes = [
  { path: '/', exact: true, name: 'Home' },
  { path: '/lecture/list', exact: true, name: 'Lecture list', element: lectureList },
  {
    path: '/lecture/applicationinquiry',
    exact: true,
    name: 'Application Inquiry',
    element: applicationInquiry,
  },
  {
    path: '/lecture/registration',
    exact: true,
    name: 'Lecture Registration',
    element: lectureRegistration,
  },
]

export default routes

import { Navigate, useRoutes } from 'react-router-dom';
// layouts
import DashboardLayout from './layouts/dashboard';
import SimpleLayout from './layouts/simple';
//
import UserPage from './pages/UserPage';
import LoginPage from './pages/LoginPage';
import Page404 from './pages/Page404';
// import DashboardAppPage from './pages/DashboardAppPage';
import RoomPage from './pages/RoomPage';
import CustomerPage from './pages/CustomerPage';
import BillPage from './pages/BillPage';

import AddUser from './pages/AddUser';
import EditUser from './pages/EditUser';
import AddRoom from './pages/AddRoom';
import EditRoom from './pages/EditRoom';
import AddCustomer from './pages/AddCustomer';
import EditCustomer from './pages/EditCustomer';
import AddBill from './pages/AddBill';
import EditBill from './pages/EditBill';
// ----------------------------------------------------------------------

export default function Router() {
  const routes = useRoutes([
    {
      path: '/api',
      element: <DashboardLayout />,
      children: [
        { element: <Navigate to="/api/users" />, index: true },
        { path: 'users', element: <UserPage /> },
        { path: 'rooms', element: <RoomPage/>},
        { path: 'customers', element: <CustomerPage/>},
        { path: 'bills', element: <BillPage /> },
        // { path: 'add', element: <AddUser />},
      ],
    },
    {
      path: '/api/users',
      element: <DashboardLayout/>,
      children:[
        { path: 'add', element: <AddUser/>},
      ],
    },
    {
      path: '/api/users',
      element: <DashboardLayout/>,
      children:[
        { path: 'edit', element: <EditUser/>},
      ],
    },
    {
      path: '/api/rooms',
      element: <DashboardLayout/>,
      children:[
        { path: 'add', element: <AddRoom/>},
      ],
    },
    {
      path: '/api/rooms',
      element: <DashboardLayout/>,
      children:[
        { path: 'edit', element: <EditRoom/>},
      ],
    },
    {
      path: '/api/customers',
      element: <DashboardLayout/>,
      children:[
        { path: 'add', element: <AddCustomer/>},
      ],
    },
    {
      path: '/api/customers',
      element: <DashboardLayout/>,
      children:[
        { path: 'edit', element: <EditCustomer/>},
      ],
    },
    {
      path: '/api/bills',
      element: <DashboardLayout/>,
      children:[
        { path: 'add', element: <AddBill/>},
      ],
    },
    {
      path: '/api/bills',
      element: <DashboardLayout/>,
      children:[
        { path: 'edit', element: <EditBill/>},
      ],
    },
    {
      path: 'login',
      element: <LoginPage />,
    },
    {
      element: <SimpleLayout />,
      children: [
        { element: <Navigate to="/api/users" />, index: true },
        { path: '404', element: <Page404 /> },
        { path: '*', element: <Navigate to="/404" /> },
      ],
    },
    {
      path: '*',
      element: <Navigate to="/404" replace />,
    },
    
  ]);

  return routes;
}

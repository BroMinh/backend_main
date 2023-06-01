// component
import SvgColor from '../../../components/svg-color';

// ----------------------------------------------------------------------
const icon = (name) => <SvgColor src={`/assets/icons/navbar/${name}.svg`} sx={{ width: 1, height: 1 }} />;

const navConfig = [
  {
    title: 'User',
    path: '/api/users',
    icon: icon('ic_user'),
  },
  {
    title: 'room',
    path: '/api/rooms',
    icon: icon('ic_bed'),
  },
  {
    title: 'customer',
    path: '/api/customers',
    icon: icon('ic_customer'),
  },
  {
    title: 'bill',
    path: '/api/bills',
    icon: icon('ic_bill'),
  },
  
];

export default navConfig;

import { Helmet } from 'react-helmet-async';
import { filter } from 'lodash';
// import { sentenceCase } from 'change-case';
// import { useState } from 'react';
import * as React from 'react';
import { useEffect, useState } from "react";
import axios from "axios";
// @mui
import {
  Card,
  Table,
  Stack,
  Paper,
  Button,
  Popover,
  Checkbox,
  TableRow,
  MenuItem,
  TableBody,
  TableCell,
  Container,
  Typography,
  IconButton,
  TableContainer,
  TablePagination,
  Link,
  Box,
  Modal,
} from '@mui/material';
// components
// import Label from '../components/label';
import Iconify from '../components/iconify';
import Scrollbar from '../components/scrollbar';
// sections

import { CustomerListHead, CustomerListToolbar } from '../sections/@dashboard/customer';

// mock
import CUSTOMERLIST from '../_mock/customer';


// ----------------------------------------------------------------------
const style = {
  position: 'absolute',
  top: '20%',
  left: '50%',
  transform: 'translate(-50%, -50%)',
  width: 400,
  bgcolor: 'background.paper',
  boxShadow: 24,
  pt: 2,
  px: 4,
  pb: 3,
};
// ----------------------------------------------------------------------


const TABLE_HEAD = [
  { id: 'customerId', label: 'ID', alignRight: false },
  { id: 'customer_name', label: 'Full Name', alignRight: false },
  { id: 'customerDateOfBirth', label: 'Birth day', alignRight: false },
  { id: 'customerIndentityCard', label: 'Identity card', alignRight: false },
  { id: 'customerCheckIn', label: 'Check in', alignRight: false },
  { id: 'customercheckout', label: 'Check out', alignRight: false },
  { id: 'customerNumberOfDay', label: 'Days', alignRight: false },
  { id: '' },
];

// ----------------------------------------------------------------------
function ChildModal() {
  const [open, setOpen] = React.useState(false);
  const handleOpen = () => {
    setOpen(true);
  };
  const handleClose = () => {
    setOpen(false);
  };

  return (
    // <React.Fragment>
    <>
      <Link onClick={handleOpen} color="error" underline="none">
            {'Delete'}
      </Link>
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="child-modal-title"
        aria-describedby="child-modal-description"
      >
        <Box sx={{ ...style}}>
          <h2 id="child-modal-title">Warning!</h2>
          <p id="child-modal-description">
            Are you sure you want to delete it?
          </p>
          <Button  variant="contained" onClick={handleClose} color='secondary' sx={{ml: 22, mr:1}}>Close</Button>
          <Button variant="contained" onClick={handleClose} color="error" >Delete</Button>
        </Box>
      </Modal>
    </>
    // </React.Fragment>
  );
}
// ----------------------------------------------------------------------

function descendingComparator(a, b, orderBy) {
  if (b[orderBy] < a[orderBy]) {
    return -1;
  }
  if (b[orderBy] > a[orderBy]) {
    return 1;
  }
  return 0;
}

function getComparator(order, orderBy) {
  return order === 'desc'
    ? (a, b) => descendingComparator(a, b, orderBy)
    : (a, b) => -descendingComparator(a, b, orderBy);
}

function applySortFilter(array, comparator, query) {
  const stabilizedThis = array.map((el, index) => [el, index]);
  stabilizedThis.sort((a, b) => {
    const order = comparator(a[0], b[0]);
    if (order !== 0) return order;
    return a[1] - b[1];
  });
  if (query) {
    return filter(array, (_customer) => _customer.customer_name.toLowerCase().indexOf(query.toLowerCase()) !== -1);
  }
  return stabilizedThis.map((el) => el[0]);
}

export default function CustomerPage() {
  const [customers, setCustomers] = useState([]);
// const deleteUser = async (id) => {
//   await axios.delete(`http://localhost:8080/users/${id}`);
//   loadUsers();
//   handleClose();
// };
useEffect(() => {
  loadCustomers();
}, []);
const loadCustomers = async () => {
  const result = await axios.get("http://localhost:8080/customers/getAll");
  setCustomers(result.data);
  console.log(result.data);
};
  const [open, setOpen] = useState(null);

  const [page, setPage] = useState(0);

  const [order, setOrder] = useState('asc');

  const [selected, setSelected] = useState([]);

  const [orderBy, setOrderBy] = useState('name');

  const [filterCustomer, setFilterCustomer] = useState('');

  const [rowsPerPage, setRowsPerPage] = useState(5);

  const handleOpenMenu = (event) => {
    setOpen(event.currentTarget);
  };

  const handleCloseMenu = () => {
    setOpen(null);
  };

  const handleRequestSort = (event, property) => {
    const isAsc = orderBy === property && order === 'asc';
    setOrder(isAsc ? 'desc' : 'asc');
    setOrderBy(property);
  };

  const handleSelectAllClick = (event) => {
    if (event.target.checked) {
      const newSelecteds = customers.map((n) => n.customerName);
      setSelected(newSelecteds);
      return;
    }
    setSelected([]);
  };

  const handleClick = (event, customerName) => {
    const selectedIndex = selected.indexOf(customerName);
    let newSelected = [];
    if (selectedIndex === -1) {
      newSelected = newSelected.concat(selected, customerName);
    } else if (selectedIndex === 0) {
      newSelected = newSelected.concat(selected.slice(1));
    } else if (selectedIndex === selected.length - 1) {
      newSelected = newSelected.concat(selected.slice(0, -1));
    } else if (selectedIndex > 0) {
      newSelected = newSelected.concat(selected.slice(0, selectedIndex), selected.slice(selectedIndex + 1));
    }
    setSelected(newSelected);
  };

  const handleChangePage = (event, newPage) => {
    setPage(newPage);
  };

  const handleChangeRowsPerPage = (event) => {
    setPage(0);
    setRowsPerPage(parseInt(event.target.value, 10));
  };

  const handleFilterByCustomer = (event) => {
    setPage(0);
    setFilterCustomer(event.target.value);
  };

  const emptyRows = page > 0 ? Math.max(0, (1 + page) * rowsPerPage - customers.length) : 0;

  const filteredCustomers = applySortFilter(customers, getComparator(order, orderBy), filterCustomer);

  const isNotFound = !filteredCustomers.length && !!filterCustomer;

  return (
    <>
      <Helmet>
        <title> Customer | Minimal UI </title>
      </Helmet>

      <Container>
        <Stack direction="row" alignItems="center" justifyContent="space-between" mb={5}>
          <Typography variant="h4" gutterBottom>
            Customer
          </Typography>
          <Button variant="contained" href='/api/customers/add' startIcon={<Iconify icon="eva:plus-fill" />}>
            New Customer
          </Button>
        </Stack>

        <Card>
          <CustomerListToolbar numSelected={selected.length} filterCustomer={filterCustomer} onFilterCustomer={handleFilterByCustomer} />

          <Scrollbar>
            <TableContainer sx={{ minWidth: 800 }}>
              <Table>
                <CustomerListHead
                  order={order}
                  orderBy={orderBy}
                  headLabel={TABLE_HEAD}
                  rowCount={customers.length}
                  numSelected={selected.length}
                  onRequestSort={handleRequestSort}
                  onSelectAllClick={handleSelectAllClick}
                />
                <TableBody>
                  {filteredCustomers.slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage).map((row) => {
                    // const { customerId, customerName, customerDateOfBirth, customerIdentityCard, customerCheckIn, customerCheckOut, customerNumberOfDay } = row;
                    const selectedCustomer= selected.indexOf(row.customer_name) !== -1;

                    return (
                      <TableRow hover key={row.customerId} tabIndex={-1} selected={selectedCustomer}>
                        <TableCell align = "left">{row.customerId}</TableCell>
                        <TableCell align = "left">{row.customer_name}</TableCell>
                        <TableCell align = "left">{row.customerDateOfBirth}</TableCell>
                        <TableCell align = "left">{row.customerIdentityCard}</TableCell>
                        <TableCell align = "left">{row.customerCheckIn}</TableCell>
                        <TableCell align = "left">{row.customercheckout}</TableCell>
                        <TableCell align = "left">{row.customerNumberOfDay}</TableCell>


                        <TableCell align="right">
                          <IconButton size="large" color="inherit" onClick={handleOpenMenu}>
                            <Iconify icon={'eva:more-vertical-fill'} />
                          </IconButton>
                        </TableCell>
                      </TableRow>
                    );
                  })}
                  {emptyRows > 0 && (
                    <TableRow style={{ height: 53 * emptyRows }}>
                      <TableCell colSpan={8} />
                    </TableRow>
                  )}
                </TableBody>

                {isNotFound && (
                  <TableBody>
                    <TableRow>
                      <TableCell align="center" colSpan={8} sx={{ py: 3 }}>
                        <Paper
                          sx={{
                            textAlign: 'center',
                          }}
                        >
                          <Typography variant="h6" paragraph>
                            Not found
                          </Typography>

                          <Typography variant="body2">
                            No results found for &nbsp;
                            <strong>&quot;{filterCustomer}&quot;</strong>.
                            <br /> Try checking for typos or using complete words.
                          </Typography>
                        </Paper>
                      </TableCell>
                    </TableRow>
                  </TableBody>
                )}
              </Table>
            </TableContainer>
          </Scrollbar>

          <TablePagination
            rowsPerPageOptions={[5, 10, 25]}
            component="div"
            count={customers.length}
            rowsPerPage={rowsPerPage}
            page={page}
            onPageChange={handleChangePage}
            onRowsPerPageChange={handleChangeRowsPerPage}
          />
        </Card>
      </Container>

      <Popover
        open={Boolean(open)}
        anchorEl={open}
        onClose={handleCloseMenu}
        anchorOrigin={{ vertical: 'top', horizontal: 'left' }}
        transformOrigin={{ vertical: 'top', horizontal: 'right' }}
        PaperProps={{
          sx: {
            p: 1,
            width: 140,
            '& .MuiMenuItem-root': {
              px: 1,
              typography: 'body2',
              borderRadius: 0.75,
            },
          },
        }}
      >
        <MenuItem>
          <Iconify icon={'eva:edit-fill'} sx={{ mr: 2 }} /> 
          <Link href="/api/customers/edit" underline="none">
            {'Edit'}
          </Link>
        </MenuItem>
        <MenuItem sx={{ color: 'error.main' }}>
          <Iconify icon={'eva:trash-2-outline'} sx={{ mr: 2 }} />
          <ChildModal/>
        </MenuItem>
      </Popover>
    </>
  );
}

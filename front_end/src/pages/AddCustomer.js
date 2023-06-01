import { Helmet } from 'react-helmet-async';
import * as React from 'react';
// @mui
import {
  Card,
  Stack,
  Button,
  Container,
  Typography,
  TextField,
  Box,
  Link,
} from '@mui/material';
// components
import Scrollbar from '../components/scrollbar';


// ----------------------------------------------------------------------
export default function AddCustomer() {

  return (
    <>
      <Helmet>
        <title> Add Customer | Minimal UI </title>
      </Helmet>
      <Container>
        <Link href="/api/customers" underline="none">
          {'Customer'}
        </Link>
        &nbsp; &gt; &nbsp;
        <Link href="/api/customers/add" underline="none">
          {'Add Customer'}
        </Link>
        <Stack direction="row" alignItems="center" justifyContent="space-between" mb={5}>
        <Typography variant="h4" gutterBottom>
            Add Customer
          </Typography>
        </Stack>
        <Card>
          <Scrollbar>
            <Box
              component="form"
              sx={{
                '& .MuiTextField-root': { m: 3, width: '35ch' },
                '& .MuiButton-root': {m: 3, width: '10ch'},
                '& .MuiFormControl-root': {m: 3, width: '35ch'}
              }}
              noValidate
              autoComplete="off"
            >
              <TextField
                  required
                  id="outlined-required"
                  type="text"
                  label="Full Name"
                  
                />
                <TextField
                  required
                  id="outlined-required"
                  type="text"
                  label="Birth day"  
                />
                <TextField
                  required
                  id="outlined-number"
                  type="number"
                  label="Identity card"  
                />
               <TextField
                  required
                  id="outlined-required"
                  type="text"
                  label="Check in"  
                />
                <TextField
                  required
                  id="outlined-required"
                  type="text"
                  label="Check out"  
                />
                <TextField
                  required
                  id="outlined-number"
                  type="number"
                  label="Number of day"  
                />

              <div>
                <Button variant="contained" color="primary">
                    Add
                </Button>
              </div>
            </Box>
          </Scrollbar>
        </Card>
      </Container>
      

    </>
  );
}

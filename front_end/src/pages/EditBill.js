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
export default function EditBill() {

  return (
    <>
      <Helmet>
        <title> Edit Bill | Minimal UI </title>
      </Helmet>
      <Container>
        <Link href="/api/bills" underline="none">
          {'Bill'}
        </Link>
        &nbsp; &gt; &nbsp;
        <Link href="/api/bills/edit" underline="none">
          {'Edit Bill'}
        </Link>
        <Stack direction="row" alignItems="center" justifyContent="space-between" mb={5}>
        <Typography variant="h4" gutterBottom>
            Edit Bill
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
                  label="Customer Name"
                  
                />
              <TextField
                  required
                  id="outlined-required"
                  label="Room Name"
                  
                />
                <TextField
                  required
                  id="outlined-number"
                  label="Price"
                  type="number"
                  InputLabelProps={{
                    shrink: true,
                  }}
                />
                <TextField
                  required
                  type='number'
                  id="outlined-required"
                  label="RoomId"
                />
                <TextField
                  required
                  type='number'
                  id="outlined-required"
                  label="CustomerId"
                />
              <div>
                <Button variant="contained" color="primary">
                    Update
                </Button>
              </div>
            </Box>
          </Scrollbar>
        </Card>
      </Container>
      

    </>
  );
}

import { Helmet } from 'react-helmet-async';
import { MuiFileInput } from 'mui-file-input';
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
export default function EditUser() {
  const [file, setFile] = React.useState(null);

  const handleChange = (newFile) => {
    setFile(newFile);
  }

  return (
    <>
      <Helmet>
        <title> Edit | Minimal UI </title>
      </Helmet>
      <Container>
        <Link href="/api/users" underline="none">
          {'User'}
        </Link>
        &nbsp; &gt; &nbsp;
        <Link href="/api/users/edit" underline="none">
          {'Edit User'}
        </Link>
        <Stack direction="row" alignItems="center" justifyContent="space-between" mb={5}>
        <Typography variant="h4" gutterBottom>
            Edit User
          </Typography>
        </Stack>
        <Card>
          <Scrollbar>
            <Box
              component="form"
              sx={{
                '& .MuiTextField-root': { m: 3, width: '35ch' },
                '& .MuiButton-root': {m: 3, width: '10ch'},
              }}
              noValidate
              autoComplete="off"
            >
              <div>
                <TextField
                  required
                  id="outlined-required"
                  label="Full Name"
                  
                />
                <MuiFileInput value={file} onChange={handleChange} label="Image" required/>
                <TextField
                  required
                  id="outlined-required"
                  label="Email"
                  
                />
                <TextField
                  id="outlined-password-input"
                  label="Password"
                  type="password"
                  autoComplete="current-password"
                />
                <TextField
                  id="outlined-password-input"
                  label="Confirm Password"
                  type="password"
                  autoComplete="current-password"
                />
              </div>
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

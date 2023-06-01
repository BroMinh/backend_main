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
  InputLabel,
  MenuItem,
  FormControl, 
  Select,
} from '@mui/material';
// components
import Scrollbar from '../components/scrollbar';

// ----------------------------------------------------------------------
export default function AddRoom() {
    const [category, setCategory] = React.useState('');

    const handleChange = (event) => {
        setCategory(event.target.value);
    };
  return (
    <>
      <Helmet>
        <title> Add Room | Minimal UI </title>
      </Helmet>
      <Container>
        <Link href="/api/rooms" underline="none">
          {'Room'}
        </Link>
        &nbsp; &gt; &nbsp;
        <Link href="/api/rooms/add" underline="none">
          {'Add Room'}
        </Link>
        <Stack direction="row" alignItems="center" justifyContent="space-between" mb={5}>
        <Typography variant="h4" gutterBottom>
            Add Room
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
                  label="Room Name"
                  
                />
               <FormControl >
                    
                    <InputLabel id="demo-simple-select-label">Category</InputLabel>
                    <Select
                    labelId="demo-simple-select-label"
                    id="demo-simple-select"
                    value={category}
                    label="Category"
                    onChange={handleChange}
                    >
                        <MenuItem value={'Cao cấp, giường đồi'}>Cao cấp, giường đôi</MenuItem>
                        <MenuItem value={'Cao cấp, giường đơn'}>Cao cấp, giường đơn</MenuItem>
                        <MenuItem value={'Thường, giường đôi'}>Thường, giường đôi</MenuItem>
                        <MenuItem value={'Thường, giường đơn'}>Thường, giường đơn</MenuItem>
                    </Select>
                </FormControl>  
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
                  id="outlined-required"
                  label="Status"
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

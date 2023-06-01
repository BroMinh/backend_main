import { faker } from '@faker-js/faker';

// ----------------------------------------------------------------------

const customers = [...Array(24)].map(() => ({
  customerId: faker.datatype.uuid(),
  customerName: faker.name.fullName(),
  customerDateOfBirth: faker.date.birthdate(),
  customerIdentityCard: faker.random.numeric(10),
  customerCheckIn: faker.date.past(),
  customerCheckOut: faker.date.future(),
  customerNumberOfDay: faker.random.numeric({max:100}),
  
}));

export default customers;

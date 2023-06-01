import { faker } from '@faker-js/faker';

// ----------------------------------------------------------------------

const bills = [...Array(24)].map(() => ({
    billId: faker.datatype.uuid(),
    customerName: faker.name.fullName(),
    roomName: faker.random.alpha({ count: 5, casing: 'upper', bannedChars: ['A'] }),
    billPrice: faker.random.numeric(),
    roomId: faker.random.numeric(),
    customerId: faker.random.numeric(),
}));

export default bills;

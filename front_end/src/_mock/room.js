import { faker } from '@faker-js/faker';
import { sample } from 'lodash';

// ----------------------------------------------------------------------

const rooms = [...Array(24)].map(() => ({
  roomId: faker.datatype.uuid(),
  roomName: faker.random.alpha({ count: 5, casing: 'upper', bannedChars: ['A'] }),
  roomCategory: sample([
    'Cao cấp, giường đôi',
    'Cao cấp, giường đơn',
    'Thường, giường đôi',
    'Thường, giường đơn',
  ]),
  roomPrice: faker.datatype.number({min: 250000, max: 900000,}),
  roomStatus: sample([
    'Sẵn sàng',
    'Đã thuê',
    'Chưa sẵn sàng',
  ]),
}));

export default rooms;

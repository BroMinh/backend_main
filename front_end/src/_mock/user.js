import { faker } from '@faker-js/faker';
import { useEffect, useState } from "react";
import axios from "axios";

// import { sample } from 'lodash';

// ----------------------------------------------------------------------



const result = axios.get("http://localhost:8080/users/getAll");
console.log(result.data);




const users = [...Array(24)].map((user,index) => ({
    // id: user.userId,
    // name: user.userName,
    // image: user.userImage,
    // email: user.userEmail,

  // id: faker.datatype.uuid(),
  // name: faker.name.fullName(),
  // image: `/assets/images/avatars/avatar_${index + 1}.jpg`,
  // email: faker.internet.email(),
  }));
// }
export default users;

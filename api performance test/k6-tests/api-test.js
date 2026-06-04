import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
  stages: 
  [
	{ duration: '1m', target: 100 },
	{ duration: '2m', target: 500 },
	{ duration: '2m', target: 1000 },
	{ duration: '1m', target: 0 },
  ]
};

export default function () {
  const res = http.get('http://host.docker.internal:8080/movie/getall');

  check(res, {
    'status is 200': (r) => r.status === 200,
  });

  //sleep(1);
}

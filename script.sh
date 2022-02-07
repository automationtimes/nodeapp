#!bin/bash
cd /var/www/html/
npm install pm2 -g
NODE_ENV=dev pm2 restart 0 --update-env

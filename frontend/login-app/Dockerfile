

FROM node as builder
WORKDIR /app


COPY package.json package-lock.json ./



RUN npm install

COPY . .

RUN npm run build 

FROM nginx:latest 



COPY --from=builder /app/dist/login-app /usr/share/nginx/html

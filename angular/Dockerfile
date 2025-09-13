FROM node:21.6.0-alpine AS build
WORKDIR /app
COPY package*.json ./
RUN npm install
RUN npx ngcc --properties es2023 browser module main --first-only --create-ivy-entry-points
COPY . .
RUN npm run build
FROM nginx:stable
RUN rm -rf /usr/share/nginx/html/*
COPY default.conf.template  /etc/nginx/templates/default.conf.template
COPY --from=build /app/dist/angular/browser/ /usr/share/nginx/html
RUN chmod 755 -R /usr/share/nginx/html
ENV API_URL http://localhost:8080/api
EXPOSE 80

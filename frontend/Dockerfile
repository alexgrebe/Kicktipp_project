FROM node:16 as build

WORKDIR /app
COPY  package.json ./
RUN npm install
COPY . .
RUN node_modules/.bin/ng build --output-path=/dist/out --configuration production
RUN npm ci && npm run build

FROM nginx:alpine
COPY --from=build /dist/out /usr/share/nginx/html
EXPOSE 4200

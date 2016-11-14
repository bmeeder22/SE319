# SE319

Portfolio 2

By: Ben Meeder and Noah Eigenfeld

Laravel Documentation: https://laravel.com/docs/5.3

#Checklist of interesting/complicated parts
-[ ] Can add an event from the homescreen
-[ ] Can add an event from the college's page
-[ ] Can Attend an event
-[ ] Events are sorted by number of attendees
-[ ] Today events show up as events that are from current day
-[ ] Web address works

#Connect to AWS: 
1. chmod 400 Portfolio2.pem
2. ssh -i "Portfolio2.pem" ec2-user@ec2-35-162-135-54.us-west-2.compute.amazonaws.com

#Kitematic setup
1. https://kitematic.com/
2. download
3. search for "bmeeder22 portfolio2"
4. Click download
5. ????
6. Profit

#Server Setup in docker
php artisan cache:clear && php artisan config:cache
php artisan serve --host 0.0.0.0 --port 8000

#PUSH TO DOCKERHUB
1. docker commit -m "Second init commit" -a "Meeder" 029530eb94d2 bmeeder22/laravel:latest
2. docker push bmeeder22/laravel

#cpy to docker
docker ps to get container id
docker cp html <container id>:/var/www local->container
docker cp cd957e0d0bbc:/var/www/html foo.txt container->local

attach terminal to docker
sudo docker exec -i -t <container id> /bin/bash

http://stackoverflow.com/questions/18878216/docker-how-to-live-sync-host-folder-with-container-folder

#updating .env vars
1. update
2. php artisan config:cache

#Run app locally
1. terminal session and go to the app directory
2. php artisan serve
3. go to http://localhost:8000

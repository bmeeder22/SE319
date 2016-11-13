# SE319

Portfolio 2

By: Ben Meeder and Noah Eigenfeld

Laravel Documentation: https://laravel.com/docs/5.3

path: cd "/Users/benjaminmeeder/Documents/School/SE 319/portfolio 2/app"

#Connect to AWS: 
1. chmod 400 Portfolio2.pem
2. ssh -i "Portfolio2.pem" ec2-user@ec2-35-162-135-54.us-west-2.compute.amazonaws.com

#setup AWS
http://www.ybrikman.com/writing/2015/11/11/running-docker-aws-ground-up/

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

#TODO
-[x] Schema php artisan migrate
-[x] College page working
-[x] Hit working
-[x] Add events
-[x] Seed database
-[x] copy to docker container
-[x] upload to AWS
-[x] serve on AWS
-[x] Docker writeup
-[x] Database seed writeup
-[x] Laravel writeup
-[x] Amazon AWS writeup

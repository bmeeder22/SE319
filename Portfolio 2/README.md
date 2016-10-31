# SE319

Portfolio 2

By: Ben Meeder and Noah Eigenfeld

Connect to AWS: 
1. chmod 400 Portfolio2.pem
2. ssh -i "Portfolio2.pem" ec2-user@ec2-35-161-211-206.us-west-2.compute.amazonaws.com

Kitematic setup
1. https://kitematic.com/
2. download
3. search for "bmeeder22 portfolio2"
4. Click download
5. ????
6. Profit

cpy to docker
docker cp foo.txt mycontainer:/foo.txt local->container
docker cp mycontainer:/foo.txt foo.txt container->local

Run app locally
1. terminal session and go to the app directory
2. php artisan serve
3. go to http://localhost:8000

TODO
-[ ] Schema php artisan migrate
-[ ] Hit working
-[ ] Seed database
-[ ] copy to docker container
-[ ] upload to AWS

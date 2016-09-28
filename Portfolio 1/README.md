Interesting Points Section

Notice that the elements of Square and how props are passed into that Component
Notice that to change the values of state variables, besides the constructor, one has to use the setState() method. This is an asynchronous call and therefore reading the value of the state variables right after the call will not have the updated state. So, it can be seen that the second parameter to the function is another function that will get called after the setState method completes.
Notice the CSS styles are associative arrays and not strings
Notice the JSX notation that allows Components to be represented as HTML/XML elements and have variables passed as parameters
Check that Tic-Tac-Toe works correctly and all win cases are correct
The win message is shown
Cats game message is shown


How to install and run

1. Download file and unzip
2. Install homebrew
3. Make sure xcode command line tools is installed
3. `brew install node`
4. Run `npm` to make sure npm is installed
5. If that doesn't work make sure this is in your bash_profile: `export PATH="$HOME/.node/bin:$PATH"`
6. Repeat step 5
7. navigate to project directory
8. run `npm start`
9. Navigate to localhost:3000

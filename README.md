# How to use bedrocks

First of all you will need, then you will have to merge them to your project by following this [guide](./HOW_TO_USE_BEDROCKS.md).

After following the guide, the below section ["What is included"](#what-is-included) will present the combined list of all the included boilerplates code.

## What is included

#### pom.xml

bedrock-sb-java-base: Contains the base dependencies and plugins required to build, test and run the application.

bedrock-sb-java-rest: Adding dependencies needed to expose a REST API endpoints and create swagger documentation.

#### Source code

bedrock-sb-java-base: Contains the main application class.

bedrock-sb-java-rest: Adding domain classes, custom exception handler and configuration for swagger documentation.

#### .gitignore

Excludes the most common clutter from source control management.

#### ErrorResponse

Response body that the application returns when an exception occurs

## Update strategy

Pulling updates from this project is in principle the responsibility of the maintainers of the child projects.
However, in case of urgent updates or fixes, or just as a general courtesy, please notify the responsible to pull the latest changes from this project.

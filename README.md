# Loft-Android

## History

### 1st iteration: October 2018 - Dec 2018

- Have 4 modules
  - `api`
  - `app`
  - `common`
  - `database`
- Kotlin DSL Gradle
- Using alpha Navigation component
- Using support library
- What have I learned (+ve)
  - Koin is more than good enough
  - Navigation component is pretty good
  - If I spend time on stuff, I can actually make code clean and organize
- What have I learned (-ve)
  - Kotlin Gradle DSL still has a bunch of bugs and stuff
  - each `ViewModel` with it's own sealed class as state causes a lot more
  trouble than expected
  - I don't know enough about how multi-module Gradle works, and it makes the
  gradle script much harder to manage than it's supposed to

### 2nd iteration: March 2019 - Present

- What I want to get right this time
  - Avoid premature optimization
    - split modules only when compile time gets long
  - Avoid spending too much time on playing with the latest tools
    - use kotlin DSL only when it's necessary
- What I want to learn this time
  - Use Apollo in a bigger scale
  - Coroutine
  - TDD with `ViewModel`
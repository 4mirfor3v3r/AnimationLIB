[![](https://jitpack.io/v/4mirfor3v3r/AnimationLIB.svg)](https://jitpack.io/#4mirfor3v3r/AnimationLIB)

# Animation for Android Development

Hello this is my first library

## Installation

### Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

```bash
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

### Step 2. Add the dependency
Add it in your build.gradle app level:
```
dependencies {
        implementation 'com.github.4mirfor3v3r:AnimationLIB:0.1.0'
}
```
## Usage
### BounceScale Animation

```
AnimationLibrary(context).BounceAnimation(View, amplitudo, frequency)
```

## Target List
- [x] BounceScale Animation
- [ ] EaseSpeed Animation
- [ ] Real Bounce Animation
- [ ] Rotate Animation
- [ ] Intent Animation

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)
`

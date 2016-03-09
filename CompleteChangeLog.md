# Introduction #

This page will detail the changes made at each version.


# Change Logs by Release #

## v0027 ##
> In development
  * Fixed [issue #207](https://code.google.com/p/evolutionchamber/issues/detail?id=#207) - the auto-updater was broken due to the changes in the format Google code uses for internal links.
  * Fixed [issue #208](https://code.google.com/p/evolutionchamber/issues/detail?id=#208) - if a newer version of EC is present in the current directory the file might get locked which might have resulted in it being prevented from deletion by other applications until the currently running EC is closed.
  * Fixed [issue #209](https://code.google.com/p/evolutionchamber/issues/detail?id=#209) - loaded properties files were not properly released after being loaded. This might have resulted in the file being locked from access of other applications until EC is closed.

## v0025/v0026 ##

  * Fixed some french.

## v0024 ##

  * Changed the way the Scout Timing field is displayed when loaded from History ("mm:ss" instead of total seconds).
  * Auto-updater now works when behind a proxy.
  * Updated the way the auto-updater retrieves the checksum of a downloaded update to account for Google Code's webpage redesign.
  * Fixed a bug that made it impossible to build Overlords while in negative supply (from using the Extractor trick).
  * Fixed a bug that caused the "total games played" and "games played per second" statistics to be calculated incorrectly (it did not take into account the games played by dead threads).
  * Fixed a bug that caused Zerglings to be treated as consuming 1 supply (instead of 0.5) when being morphed into Banelings.  This caused the supply to incorrectly lower by 0.5 every time a Baneling was built.
  * Added Spanish language support (submitted by Jota).
  * Added French language support (submitted by Zil).

## v0023 ##

  * Security enhancement: Auto-updater now does a file integrity check.
  * Auto-updater download progress bar now displays properly.
  * Fixed a Mac bug that displayed the "Preferences" menu option when it shouldn't have been shown at all.
  * Window size and selected language preferences are now saved in the user's profile.
  * Added Korean and German language support.
  * Added an option to supress Extractors for gas-free builds.
  * Increased games played per second by another 110%!

## v0022 ##

  * Added better Mac support
  * Added internationalization support for the GUI
  * Waypoints can be added/removed in the GUI
  * Increased games played per second by 40% using a caching mechanism
  * Fixed issue with waypoints ignoring bases and Goals not reporting bases
  * Added a History tab
  * Fixed an issue where parts of the window were cut off on smaller screen resolutions

## v0020 ##

  * Added drone scout timing to final way point.

## v0017 ##

  * Fixed bug where any build with waypoints was not being solved.

## v0016 ##

  * Carapace upgrades now cost the correct amount.
  * Auto updater now implemented. Will now ask if you want to go to a new version!
  * Ability to switch drones on/off gas
  * Drone movements to/from gas now have 2 second delay
  * Fixed max larva bug, now is hatches times 19.
  * Fixed max supply bug, now caps at 200.
  * Implemented settings screen, to turn on/off extractor trick, and other things.
  * Spore crawler now is a final destination.
  * Can now have a waypoint without a final, and it will still calculate.
  * Gas extractors now contribute to score.
  * Now have simplified build format, with just supply/major buildings
  * Slightly increased value of drones on satisfied builds.
  * Gave mad props to some awesome contributors.
  * Processors now limited to 4 times your computer's processor count. Overloading your processors can be good, because it spawns more strains, which has a higher chance of getting a more complete build over a long period of time.
  * Evolution rate renamed to Mutation rate, more representative.
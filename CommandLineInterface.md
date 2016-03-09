The Evolution Chamber CLI is a way of generating Starcraft 2 build orders from the command line.  You define your waypoint goals in a text file, optionally pass it some arguments, and let it do its work.  For example, the following command will basically run until it stops finding very many new build orders and will only output the best build order it finds:

`java -jar evolutionchamber-cli-version-0027.jar -a 200 -f waypoints.txt`

Keep reading for instructions on how to define the waypoints and for a description of all the arguments.

# Waypoints File #

The waypoints are simply defined in a text file.  Here is an example:

```
#the time to send a scouting worker (optional)
scout-timing 2:00

waypoint 3:00
	zergling 6
	
waypoint 8:00
	spine-crawler 2
	roach 7

waypoint 2:00:00
	mutalisk 6
	flyer-attack 2
```

If you have used the GUI, then the concepts here will be very familiar to you.  The first line instructs Evolution Chamber to send out a scouting worker at the two minute mark (lines beginning with "#" are ignored).  We then jump straight to the waypoint definitions.  The first waypoint has a deadline of three minutes, at which point six Zerglings must be produced.  For the second waypoint, two Spine Crawlers and seven Roaches must be completed by the eight-minute mark.  Finally, the last waypoint defines that six Mutalisks and Flyer Attack Level 2 be completed at the end.

Here is a list of the names of all the units, buildings, and upgrades that can be defined within a waypoint:

| **Units** | **Buildings** | **Upgrades** |
|:----------|:--------------|:-------------|
| baneling  | baneling-nest | adrenal-glands |
| brood-lord | evolution-chamber | burrow       |
| corruptor | extractor     | carapace     |
| drone     | greater-spire | centrifugal-hooks |
| hydralisk | hatchery      | chitinous-plating |
| infestor  | hive          | flyer-armor  |
| mutalisk  | hydralisk-den | flyer-attacks |
| overlord  | infestation-pit | glial-reconstitution |
| overseer  | lair          | grooved-spines |
| queen     | nydus-network | melee        |
| roach     | nydus-worm    | metabolic-boost |
| ultralisk | roach-warren  | missile      |
| zergling  | spawning-pool | neural-parasite |
|           | spine-crawler | pathogen-glands |
|           | spire         | pneumatized-carapace |
|           | spore-crawler | tunneling-claws |
|           | ultralisk-cavern | ventral-sacs |

# Arguments #

Evolution Chamber CLI works without needing to specify any arguments (other than the name of the waypoints file), but arguments can be used to fine-tune how the CLI operates.

### `-t <threads>` ###
The number of threads to spawn.  Defaults to the number of available processors.

### `-a <max-age>` ###
When a simulation has been running long enough, it will generate new builds less and less frequently.  This argument will terminate the simulation when the fittest build of each thread reaches this age (a good value is 200).

### `-i <minutes>` ###
The number of minutes to run the simulation for.  When this time is reached, the simulation will stop.

### `-f` ###
Instructs Evolution Chamber to only output the fittest build when the simulation ends.  Only applicable if the arguments -a or -i are specified.  Normally, it will output a build order whenever it finds a new one.

### `-y` ###
Outputs each build order in YABOT format.

### `-l <language>` ###
(lower-case L) Sets the language.  Supported: en, ko, de, es, fr.

### `-s` ###
Outputs a sample waypoint file.

### `--help` ###
Prints a help message describing these arguments.
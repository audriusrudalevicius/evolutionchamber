# Introduction #

The following document compares the speeds of different versions of EvolutionChamber by looking at the number of games played per second.  It uses the `com.fray.evo.SpeedTest` class, which runs three tests:

**Test 1:** No waypoints, with a final destination.

**Test 2:** One waypoint, the final destination is empty.

**Test 3:** Multiple waypoints with a final destination.

The test program was run multiple times for each version.

# Results #

| | **v0022 ([r127](https://code.google.com/p/evolutionchamber/source/detail?r=127))** | **[r177](https://code.google.com/p/evolutionchamber/source/detail?r=177)** |
|:|:-----------------------------------------------------------------------------------|:---------------------------------------------------------------------------|
| **Run 1, Test 1** | 2790.7                                                                             | 3037.4                                                                     |
| Run 1, Test 2 | 425.35                                                                             | 2690.4                                                                     |
| Run 1, Test 3 | 2685.15                                                                            | 6530.55                                                                    |
| **Run 2, Test 1** | 2547.9                                                                             | 1874.15                                                                    |
| Run 2, Test 2 | 412.05                                                                             | 3145                                                                       |
| Run 2, Test 3 | 2755.1                                                                             | 5105.85                                                                    |
| **Run 3, Test 1** | 2605.6                                                                             | 2790.2                                                                     |
| Run 3, Test 2 | 336.9                                                                              | 3170.85                                                                    |
| Run 3, Test 3 | 2564.7                                                                             | 5034.5                                                                     |
| **Run 4, Test 1** | 3160.7                                                                             | 2224.9                                                                     |
| Run 4, Test 2 | 422.75                                                                             | 3042.7                                                                     |
| Run 4, Test 3 | 2552.25                                                                            | 4621.3                                                                     |
| **Run 5, Test 1** | 2545.5                                                                             | 2022.9                                                                     |
| Run 5, Test 2 | 472.5                                                                              | 3293.65                                                                    |
| Run 5, Test 3 | 2656.05                                                                            | 4364.6                                                                     |
| **Total** | _28933.2_                                                                          | _52948.95_                                                                 |
| **Average** | _1928.88_                                                                          | _3529.93_                                                                  | ~83% increase                                                              |


| | **v0022 ([r127](https://code.google.com/p/evolutionchamber/source/detail?r=127))** | **[r225](https://code.google.com/p/evolutionchamber/source/detail?r=225)** |
|:|:-----------------------------------------------------------------------------------|:---------------------------------------------------------------------------|
| **Run 1, Test 1** | 2602.75                                                                            | 2598.35                                                                    |
| Run 1, Test 2 | 391.35                                                                             | 2599                                                                       |
| Run 1, Test 3 | 2622.15                                                                            | 5590.2                                                                     |
| **Run 2, Test 1** | 2640.6                                                                             | 2494.9                                                                     |
| Run 2, Test 2 | 443.85                                                                             | 2982.65                                                                    |
| Run 2, Test 3 | 2572.05                                                                            | 5425.05                                                                    |
| **Run 3, Test 1** | 2451.05                                                                            | 2802.7                                                                     |
| Run 3, Test 2 | 413.5                                                                              | 2924.85                                                                    |
| Run 3, Test 3 | 2533.15                                                                            | 5839.8                                                                     |
| **Run 4, Test 1** | 2552.45                                                                            | 3052.25                                                                    |
| Run 4, Test 2 | 320.3                                                                              | 3008.7                                                                     |
| Run 4, Test 3 | 2605.9                                                                             | 5831.3                                                                     |
| **Run 5, Test 1** | 2233.5                                                                             | 3878.45                                                                    |
| Run 5, Test 2 | 373.5                                                                              | 2847.9                                                                     |
| Run 5, Test 3 | 2686.1                                                                             | 5913.95                                                                    |
| **Total** | _27442.2_                                                                          | _57790.05_                                                                 |
| **Average** | _1829.48_                                                                          | _3852.67_                                                                  | ~110% increase                                                             |
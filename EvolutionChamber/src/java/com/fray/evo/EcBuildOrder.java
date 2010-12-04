package com.fray.evo;

import static com.fray.evo.ui.swingx.EcSwingXMain.messages;

import java.io.Serializable;
import java.util.*;

import com.fray.evo.util.ActionList;
import com.fray.evo.action.EcAction;
import com.fray.evo.util.BuildingLibrary;

public final class EcBuildOrder extends EcState implements Serializable
{
	static final long		serialVersionUID	= 1L;
	public int				dronesGoingOnMinerals	= 6;	
	public int				dronesGoingOnGas	= 0;
	public int				dronesOnMinerals	= 0;
	public int				dronesOnGas			= 0;
	public int				evolvingSpires		= 0;
	public int				queensBuilding		= 0;
	public int				spiresInUse			= 0;
	public int				evolutionChambersInUse;
        public int                              busyMainBuildings        = 0;
        public ArrayList<EcAction>              busyLairs                = new ArrayList<EcAction>();
	public boolean 			droneIsScouting		= false;

	transient ActionList	futureAction		= new ActionList();
	public ArrayList<EcAction>		actions				= new ArrayList<EcAction>();

	public EcBuildOrder()
	{
        super();
        addFutureAction(5, new Runnable(){
            @Override
            public void run()
            {
                    dronesOnMinerals +=6;
                    dronesGoingOnMinerals -=6;
            }});
	}
	
	public EcBuildOrder(EcState importDestination)
	{
		//Fixed: Need to assign this to the variable, not the other way around.
		//-Lomilar
		importDestination.assign(this);
	}

	public void tick(EcEvolver e)
	{
		executeLarvaProduction(e);
		accumulateMaterials();
	}
	
	@Override
	public EcBuildOrder clone() throws CloneNotSupportedException
	{
		final EcBuildOrder s = new EcBuildOrder();
		assign(s);
		return s;
	}

	private void assign(final EcBuildOrder s)
	{
		s.dronesGoingOnMinerals = dronesGoingOnMinerals;
		s.dronesGoingOnGas = dronesGoingOnGas;
		s.dronesOnMinerals = dronesOnMinerals;
		s.dronesOnGas = dronesOnGas;
		s.queensBuilding = queensBuilding;
		s.evolutionChambersInUse = evolutionChambersInUse;
		super.assign(s);
	}

    @Override
	public String toString()
	{
		return toUnitsOnlyString().replaceAll("\n"," ");
	}
	
	public String toShortString()
	{
		return (messages.getString("short.time") + timestamp() + "\t"+messages.getString("short.minerals")+":" + (int) minerals + "\t"+messages.getString("short.gas")+":" + (int) gas + "\t"+messages.getString("short.larva")+":" + getLarva() + "\t"+messages.getString("short.supply")+":"
				+ ((int) supplyUsed) + "/" + supply());
	}

	public ArrayList<EcAction> getActions()
	{
		return actions;
	}

	public void addAction(EcAction ecActionBuildDrone)
	{
		actions.add(ecActionBuildDrone);
	}

	public void addFutureAction(int time, Runnable runnable)
	{
		time = seconds + time;
		if (futureAction == null)
			futureAction = new ActionList();
		futureAction.put(time, runnable);
		actionLength++;
	}

	public Runnable getFutureAction(int time)
	{
		Runnable result = futureAction.get(time);
		return result;
	}

	public boolean nothingGoingToHappen()
	{
		return futureAction.hasFutureActions();
	}

	public void consumeLarva(final EcEvolver e)
	{
		final EcBuildOrder t = this;
		
		int highestLarvaHatch = 0;
		int highestLarva = 0;
		
		for (int i = 0;i < larva.size();i++)
			if (larva.get(i) > highestLarva)
			{
				highestLarvaHatch = i;
				highestLarva = larva.get(i); 
			}
		final int finalHighestLarvaHatch = highestLarvaHatch;
				
		setLarva(finalHighestLarvaHatch,getLarva(finalHighestLarvaHatch) - 1);
	}

	private void executeLarvaProduction(final EcEvolver e)
	{
		for (int hatchIndex = 0;hatchIndex < larva.size();hatchIndex++)
			executeLarvaProduction(e,hatchIndex);
	}
	
	private void executeLarvaProduction(final EcEvolver e, final int hatchIndex)
	{
		if (getLarva(hatchIndex) < 3)
		{
			if (larvaProduction.get(hatchIndex) == 15)
			{
				if (e.debug)
					e.obtained(this, " @"+messages.getString("Hatchery") + " #" + (hatchIndex+1) + " " + messages.getString("Larva")+" +1");
				setLarva(hatchIndex,getLarva(hatchIndex)+1);
				larvaProduction.set(hatchIndex,0);
			}
			larvaProduction.set(hatchIndex,Optimization.inte(larvaProduction.get(hatchIndex)+1));
		}
	}
	
	public boolean hasSupply(double i)
	{
		if (supplyUsed + i <= supply())
			return true;
		return false;
	}

	public int mineralPatches()
	{
		return bases() * 8;
	}

	int[]		patches				= new int[24];
	public int	extractorsBuilding	= 0;
	public int	hatcheriesBuilding	= 0;
	public int	spawningPoolsInUse	= 0;
	public int	roachWarrensInUse	= 0;
	public int	infestationPitInUse	= 0;
	public int	nydusNetworkInUse = 0;

    static double[][] cachedMineralsMined = new double[200][200];

    public double mineMinerals() {
        int mineralPatches = mineralPatches();
        if(dronesOnMinerals <= 0 || mineralPatches <= 0)
            return 0;

        if(dronesOnMinerals >= 200 || mineralPatches >= 200)
            return mineMineralsImpl();

        if(cachedMineralsMined[mineralPatches][dronesOnMinerals] == 0)
            cachedMineralsMined[mineralPatches][dronesOnMinerals] = mineMineralsImpl();

        return cachedMineralsMined[mineralPatches][dronesOnMinerals];
    }

	// Mines minerals on all bases perfectly per one second.
	private double mineMineralsImpl()
	{
		int drones = dronesOnMinerals;
        int mineralPatches = mineralPatches();
        if (patches.length < bases() * 8)
			patches = new int[bases() * 8];

		for (int i = 0; i < mineralPatches; i++)
			patches[i] = 0;
		for (int i = 0; i < mineralPatches; i++)
			// Assign first drone
			if (drones > 0)
			{
				patches[i]++;
				drones--;
			}
		if (drones > 0)
			for (int i = 0; i < mineralPatches; i++)
				// Assign second drone
				if (drones > 0)
				{
					patches[i]++;
					drones--;
				}
		if (drones > 0)
			for (int i = 0; i < mineralPatches; i++)
				// Assign third drone
				if (drones > 0)
				{
					patches[i]++;
					drones--;
				}
		// Assume half the patches are close, and half are far, and the close
		// ones have more SCVs. (perfect)
		double mineralsMined = 0.0;
		for (int i = 0; i < mineralPatches; i++)
			if (i < mineralPatches / 2) // Close patch
				if (patches[i] == 0)
					;
				else if (patches[i] == 1)
					mineralsMined += 45.0 / 60.0; // Per TeamLiquid
				else if (patches[i] == 2)
					mineralsMined += 90.0 / 60.0; // Per TeamLiquid
				else
					mineralsMined += 102.0 / 60.0; // Per TeamLiquid
			else if (patches[i] == 0)
				;
			else if (patches[i] == 1)
				mineralsMined += 35.0 / 60.0; // Per TeamLiquid
			else if (patches[i] == 2)
				mineralsMined += 75.0 / 60.0; // Per TeamLiquid
			else
				mineralsMined += 100.0 / 60.0; // Per TeamLiquid

        return mineralsMined;
	}

    static double[][] cachedGasMined = new double[200][200];

    public double mineGas()
    {
    	int gasExtra = getGasExtractors();
        if (gasExtra == 0 || dronesOnGas == 0)
			return 0;

        if(gasExtra >= 200 || dronesOnGas >= 200)
            return mineGasImpl();

        if(cachedGasMined[gasExtra][dronesOnGas] == 0)
            cachedGasMined[gasExtra][dronesOnGas] = mineGasImpl();

        return cachedGasMined[gasExtra][dronesOnGas];
    }

	// Mines gas on all bases perfectly per one second.
	private double mineGasImpl()
	{
		int drones = dronesOnGas;
		int[] extractors = new int[Math.min(getGasExtractors(),bases()*2)]; // Assign drones/patch
		for (int i = 0; i < extractors.length; i++)
			extractors[i] = 0;
		for (int i = 0; i < extractors.length; i++)
			// Assign first drone
			if (drones > 0)
			{
				extractors[i]++;
				drones--;
			}
		for (int i = 0; i < extractors.length; i++)
			// Assign second drone
			if (drones > 0)
			{
				extractors[i]++;
				drones--;
			}
		for (int i = 0; i < extractors.length; i++)
			// Assign third drone
			if (drones > 0)
			{
				extractors[i]++;
				drones--;
			}
		double gasMined = 0.0;
		for (int i = 0; i < extractors.length; i++)
			if (extractors[i] == 0)
				;
			else if (extractors[i] == 1)
				gasMined += 38.0 / 60.0; // Per TeamLiquid
			else if (extractors[i] == 2)
				gasMined += 82.0 / 60.0; // Per TeamLiquid
			else
				gasMined += 114.0 / 60.0; // Per TeamLiquid

		return gasMined;
	}

	private void accumulateMaterials()
	{
		double mins = mineMinerals();
		minerals += mins;
		totalMineralsMined += mins;
		gas += mineGas();
	}

	public String timestampIncremented(int increment)
	{
		int incrementedSeconds = seconds + increment;
		return incrementedSeconds / 60 + ":" + (incrementedSeconds%60 < 10 ? "0" : "") + incrementedSeconds % 60;
	}

	public int extractors()
	{
		return (bases() + hatcheriesBuilding) * 2;
	}

        public void consumeHatch(EcAction action)
	{
		busyMainBuildings++;
                if(getHatcheries() - busyMainBuildings < 0){
                    busyLairs.add(action);
                }
	}

    public void unconsumeHatch(EcAction action) {
        busyMainBuildings--;
        if(busyLairs.contains(action)){
            busyLairs.remove(action);
        }
    }
}

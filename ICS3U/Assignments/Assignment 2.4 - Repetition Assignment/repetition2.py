# James
# repetition2.py

# Here we store the original population so we can compare the new one to the old easily. Then set dynamic pop. to initial pop. and set a year counter.
initialPopulation = 8.017
population = initialPopulation
years = 0
while population < initialPopulation*2:
    # a rate of 0.9% means the population gets multiplied by 1.009 each year.
    population *= 1.009
    years += 1

print(f"It would take {years} years for the population to double at the rate of 0.9% per year.")
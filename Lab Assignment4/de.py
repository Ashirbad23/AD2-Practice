import numpy as np

# Generate a random integer array of size 1000 with values in the range 0 to 1000
array = np.random.randint(0, 1001, size=1000)

arr_str = ', '.join(map(str, array))

print(arr_str)

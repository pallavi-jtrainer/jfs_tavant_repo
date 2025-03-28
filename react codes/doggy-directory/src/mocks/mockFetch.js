const breedsResponseList = {
    message: {
        boxer: [],
        dalmatian: [],
        husky: [],
        beagle: []
    }
}

const dogImagesResponse = {
    message: [
        'https://images.dog.ceo/breeds/beagle/Joey.jpg',
        'https://images.dog.ceo/breeds/beagle/n02088364_10108.jpg',
        'https://images.dog.ceo/breeds/boxer/n02108089_1031.jpg',
        'https://images.dog.ceo/breeds/boxer/n02108089_10774.jpg',
        'https://images.dog.ceo/breeds/dalmatian/cooper1.jpg',
        'https://images.dog.ceo/breeds/husky/MsMilo_Husky1.jpg',
        'https://images.dog.ceo/breeds/husky/n02110185_10273.jpg'
    ]
}

// Simulate API request
export default async function mockFetch(url) {
    switch(url) {
        case 'https://dog.ceo/api/breeds/list/all':
            return Promise.resolve({
                status: 200,
                json: async () => breedsResponseList
            });
        case 'https://dog.ceo/api/breeds/boxer/images':
        case 'https://dog.ceo/api/breeds/dalmatian/images':
        case 'https://dog.ceo/api/breeds/husky/images':
        case 'https://dog.ceo/api/breeds/beagle/images':
            return Promise.resolve({
                status: 200,
                json: async () => dogImagesResponse
            });
        default:
            return Promise.reject(new Error(`Invalid URL or Unhandled Request: ${url}`));
    }
}
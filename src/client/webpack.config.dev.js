const webpack = require('webpack');
const path = require('path');

module.exports = {
    entry: {
        t4confluence: [
            'babel-polyfill',
            './react/app.js'
        ]
    },

    output: {
        path: path.join(__dirname, 'react'),
        filename: '../../main/resources/js/[name].pack.js'
    },
    module: {
        rules: [
            {
                test: /\.(js|jsx)$/,
                exclude: [/node_modules/],
                use: [{
                    loader: 'babel-loader',
                    options: {
                        presets: ['es2015', 'react'],
                        plugins: [
                            ['import', { libraryName: 'antd', style: true }]
                        ]
                    },
                }],
            },
            {
                test: /\.json$/,
                use: [
                    'json-loader'
                ]
            }
        ]
    }
};